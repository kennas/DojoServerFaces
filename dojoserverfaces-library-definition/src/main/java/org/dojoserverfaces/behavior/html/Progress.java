package org.dojoserverfaces.behavior.html;

import javax.faces.component.behavior.ClientBehaviorContext;

import org.dojoserverfaces.build.annotation.Attribute;
import org.dojoserverfaces.build.annotation.Behavior;
import org.dojoserverfaces.component.behavior.BehaviorBase;

@Behavior
public class Progress extends BehaviorBase {
    private String target;
    private Integer time;
    private String url;

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        StringBuilder script = new StringBuilder(
                "(function xhr(){ var configuration = dojo.xhrGet({handleAs : 'text',timeout: 30000, url:'");
        script.append(this.url).append("'});configuration.then(function(res){");
        String clientId = getRenderedClientIdById(this.target, behaviorContext);
        appendGetDijit(script, clientId);
        script.append(".update({progress : res*100+'%',maximum:1});if(res<1)")
                .append("{");
        script.append("setTimeout(xhr,").append(time).append(");");
        script.append("}else{");
        appendGetDijit(script, clientId);
        script.append(".update({indeterminate:false,maximum:1});}},function(err) {console.log('wrong');})})();");
        return script.toString();
    }

    /**
     * component id to act on
     */
    @Attribute
    public String getTarget() {
        return target;
    }

    public void setTarget(String source) {
        this.target = source;
    }

    /**
     * Checking interval 
     */
    @Attribute
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer source) {
        this.time = source;
    }

    /**
     * a web service url. it should return a value between 0 and 1
     */
    @Attribute
    public String getUrl() {
        return url;
    }

    public void setUrl(String source) {
        this.url = source;
    }

 
}
