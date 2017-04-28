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
public class PostScoresResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ScoreIdModel scoreIdModel;

    /**
     * @param scoreIdModel
     */

    public void setScoreIdModel(ScoreIdModel scoreIdModel) {
        this.scoreIdModel = scoreIdModel;
    }

    /**
     * @return
     */

    public ScoreIdModel getScoreIdModel() {
        return this.scoreIdModel;
    }

    /**
     * @param scoreIdModel
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public PostScoresResult scoreIdModel(ScoreIdModel scoreIdModel) {
        setScoreIdModel(scoreIdModel);
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
        if (getScoreIdModel() != null)
            sb.append("ScoreIdModel: ").append(getScoreIdModel());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PostScoresResult == false)
            return false;
        PostScoresResult other = (PostScoresResult) obj;
        if (other.getScoreIdModel() == null ^ this.getScoreIdModel() == null)
            return false;
        if (other.getScoreIdModel() != null && other.getScoreIdModel().equals(this.getScoreIdModel()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScoreIdModel() == null) ? 0 : getScoreIdModel().hashCode());
        return hashCode;
    }

    @Override
    public PostScoresResult clone() {
        try {
            return (PostScoresResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
