package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;

@Behavior
public class GridMergeCells extends GridBehaviorBase {
    private String inputRow;
    private String inputStartCol;
    private String inputEndCol;
    private String inputMajor;

    /**
     * id of an input component it's an Integer, it's the index of the row which
     * have cells to be merged. If it's a function, it's a predicate to decide
     * which rows are to be merged. It takes an integer (the row index), and
     * should return true or false;
     */
    @Attribute(required = true)
    public String getInputRow() {
        return inputRow;
    }

    public void setInputRow(String inputRow) {
        this.inputRow = inputRow;
    }

    /**
     * id of an input component the component value is the column index of the
     * left most cell that shall be merged.
     */
    @Attribute(required = true)
    public String getInputStartCol() {
        return inputStartCol;
    }

    public void setInputStartCol(String inputStartCol) {
        this.inputStartCol = inputStartCol;
    }

    /**
     * id of an input component the component value is the column index of the
     * right most cell that shall be merged.
     */
    @Attribute(required = true)
    public String getInputEndCol() {
        return inputEndCol;
    }

    public void setInputEndCol(String inputEndCol) {
        this.inputEndCol = inputEndCol;
    }

    /**
     * id of an input component the component value is the column index of the
     * cell whose content should be used as the content of the merged cell. It
     * must be larger than or equal to the startColumnIndex, and less than or
     * equal to the endColumnIndex. If it is omitted, the content of the leading
     * edge (left-most for ltr, right most for rtl) cell will be used.
     * 
     */
    @Attribute
    public String getInputMajor() {
        return inputMajor;
    }

    public void setInputMajor(String inputMajor) {
        this.inputMajor = inputMajor;
    }

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder();
        String target = getClientId(getTarget(), behaviorContext);
        String row = this.getIntValue(this.inputRow, behaviorContext);
        String startcol = this.getIntValue(this.inputStartCol, behaviorContext);
        String endcol = this.getIntValue(this.inputEndCol, behaviorContext);
        String value = this.getIntValue(this.inputMajor, behaviorContext);
        if ("".equals(row) || "".equals(startcol) || "".equals(endcol)) {
            return script.toString();
        }
        appendGetDijit(script, target);
        script.append(".mergeCells(").append(row).append(",").append(startcol)
                .append(",").append(endcol);
        if(! "".equals(value))
        {
            script.append(",").append(value);
        }
      
        script.append(");");
        return script.toString();
    }

    private String getIntValue(String id, ClientBehaviorContext behaviorContext) {
        String clientId = getClientId(id, behaviorContext);
        StringBuilder sb = new StringBuilder();
        if (clientId == null || "".equals(clientId)) {
            return sb.toString();
        }
        sb.append("parseInt(dojo.byId(\"").append(clientId)
                .append("\").value,10)");
        return sb.toString();
    }

}
