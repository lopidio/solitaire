/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/PostScores" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostScoresRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private ScoreModel scoreModel;

    /**
     * @param scoreModel
     */

    public void setScoreModel(ScoreModel scoreModel) {
        this.scoreModel = scoreModel;
    }

    /**
     * @return
     */

    public ScoreModel getScoreModel() {
        return this.scoreModel;
    }

    /**
     * @param scoreModel
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostScoresRequest scoreModel(ScoreModel scoreModel) {
        setScoreModel(scoreModel);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getScoreModel() != null)
            sb.append("ScoreModel: ").append(getScoreModel());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostScoresRequest == false)
            return false;
        PostScoresRequest other = (PostScoresRequest) obj;
        if (other.getScoreModel() == null ^ this.getScoreModel() == null)
            return false;
        if (other.getScoreModel() != null && other.getScoreModel().equals(this.getScoreModel()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScoreModel() == null) ? 0 : getScoreModel().hashCode());
        return hashCode;
    }

    @Override
    public PostScoresRequest clone() {
        return (PostScoresRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public PostScoresRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
