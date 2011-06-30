package org.dojoserverfaces.behavior.html.grid;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Behavior;

/**
 * This behavior will allow you to export the whole grid's data
 */
@Behavior
public class GridExportAll extends GridExportBase {

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.faces.component.behavior.ClientBehaviorBase#getScript(javax.faces
     * .component.behavior.ClientBehaviorContext)
     */
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return this.getRenderedAllScript(this.getType(), behaviorContext);

    }

}
