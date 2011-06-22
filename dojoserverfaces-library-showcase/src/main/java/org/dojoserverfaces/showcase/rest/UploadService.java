package org.dojoserverfaces.showcase.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.wink.common.model.multipart.BufferedInMultiPart;
import org.apache.wink.common.model.multipart.InPart;
import org.dojoserverfaces.showcase.data.model.UploadRecord;
import org.dojoserverfaces.showcase.data.model.UploadRecord.UploadFile;

/**
 * UploadService is written to provide upload service for the
 * dojox.form.Uploader widget.
 */
@Path("upload")
public class UploadService {
    @Context
    private ServletConfig servletConfig;

    /**
     * upload method receives a JAX-RS Wink BufferedInMultiPart payload. Iterate
     * over the "parts" of this inbound multipart/form-data payload to retrieve
     * each part of the message body. Messages with a Content-Type of
     * multipart/form-data are typically submissions of HTML forms with standard
     * form input fields plus file input fields.
     * 
     * @param servletConfig
     *            injected by the JAX-RS engine
     * @param multiPart
     *            the HTTP message payload, already parsed into "parts"
     * @throws IOException
     * @throws Exception
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public void upload(BufferedInMultiPart multiPart) throws IOException {
        List<InPart> parts = multiPart.getParts();
        for (InPart part : parts) {
            MultivaluedMap<String, String> headers = part.getHeaders();
            if (headers.containsKey("Content-Disposition")) {
                Map<String, String> cdHeaderMap = parseCDHeader(headers.get(
                        "Content-Disposition").get(0));
                String filename = getFilename(cdHeaderMap);
                if (filename != null) {
                    Long id = System.currentTimeMillis();
                    File uploadFile = new File(getUploadPath(), filename + "."
                            + id);
                    saveFile(part.getInputStream(), uploadFile);
                    UploadRecord.add(new UploadFile(id, uploadFile));
                }
            }
        }
    }

    @Path("file/{id}")
    @GET
    public Response download(@PathParam("id") Long id)
            throws FileNotFoundException {
        UploadFile uploadFile = UploadRecord.findById(id);
        if (uploadFile == null || !uploadFile.exists()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response
                .ok()
                .type(MediaType.APPLICATION_OCTET_STREAM_TYPE)
                .header("Content-Disposition",
                        "attachment;filename=" + uploadFile.getDisplayName())
                .entity(uploadFile.getInputStream()).build();
    }

    @Path("{id}")
    @DELETE
    public Response remove(@PathParam("id") Long id) {
        UploadFile uploadFile = UploadRecord.findById(id);
        if (uploadFile == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        UploadRecord.removeById(id);
        return Response.ok().build();
    }

    private void saveFile(InputStream is, File file) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            int n = -1;
            byte[] buf = new byte[1024 * 10];
            while ((n = is.read(buf)) > 0) {
                fos.write(buf, 0, n);
            }
        }
        finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    private File getUploadPath() {
        String uploadPath = servletConfig.getServletContext().getRealPath(
                "/upload");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        return uploadDir;
    }

    private String getFilename(Map<String, String> cdHeaderMap) {
        String filename = cdHeaderMap.get("filename");
        if (filename != null) { // this part is a file
            if ("".equals(filename)) {
                // probably came from Internet Explorer
                // so let's just use the "name" as the filename
                filename = cdHeaderMap.get("name");
                if (filename.endsWith("[]")) {
                    filename = filename.substring(0, filename.length() - 2);
                }
            }
            return filename;
        }
        return null;
    }

    private Map<String, String> parseCDHeader(String value) {
        Map<String, String> result = new HashMap<String, String>();
        String[] entries = value.split(";");
        for (String entry : entries) {
            entry = entry.trim();
            int eqIdx = entry.indexOf('=');
            if (eqIdx < 0) {
                result.put("Content-Disposition", entry);
            }
            else {
                // TODO: to use the regex way?
                String k = entry.substring(0, eqIdx).trim();
                String v = entry.substring(eqIdx + 1).trim();
                result.put(k, v.substring(1, v.length() - 1));
            }
        }
        return result;
    }
}
