package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.util.Helper;

/**
 * 
 * This class is base class of Grid Export classes it provides destination and
 * seperator (for csv)
 */
public abstract class GridExportBase extends GridBehaviorBase {
    private String destination;
    private String sep = ",";
    private String type;

    /*
     * this method create js code of exportAll behavior
     */
    protected String getRenderedAllScript(String type,
            ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        String destinationId = getClientId(this.getDestination(),
                behaviorContext);
        String sourceId = getClientId(getTarget(), behaviorContext);
        if (null == destinationId || null == sourceId
                || "".equals(destinationId) || "".equals(sourceId)) {
            return script.toString();

        }
        appendGetDijit(script, sourceId);
        script.append(".exportGrid(\"").append(type).append("\"");
        if ("csv".equals(type)) {
            script.append(",{").append("writerArgs:{ separator:")
                    .append(Helper.quote(this.getSep())).append("}}");
        }
        script.append(",function(csvresult){");
        appendSetElementAttr(script, destinationId, "value", "csvresult");
        script.append("});");
        return script.toString();

    }

    /*
     * this method create js code of exportselectd behavior
     */
    protected String getRenderedSelectedScript(String type,
            ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String destinationId = getClientId(this.getDestination(),
                behaviorContext);
        String sourceId = getClientId(getTarget(), behaviorContext);
        if (null == destinationId || null == sourceId
                || "".equals(destinationId) || "".equals(sourceId)) {
            return script.toString();

        }
        appendGetDijit(result, sourceId);
        result.append(".").append("exportSelected").append("(\"").append(type)
                .append("\"");
        if ("csv".equals(type)) {
            result.append(",{").append("separator:")
                    .append(Helper.quote(this.getSep())).append("}");
        }
        result.append(")");
        appendSetElementAttr(script, destinationId, "value", result.toString());
        return script.toString();
    }

    /**
     * Destination of exported data
     */
    @Attribute(required = true)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * seperator of CSV file
     */
    @Attribute
    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    /**
     * Exported data's type e.g. csv or table.
     */
    @Attribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
