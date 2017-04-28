/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScoresScoreid"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetScoresScoreidResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ScorePositionModel scorePositionModel;

    /**
     * @param scorePositionModel
     */

    public void setScorePositionModel(ScorePositionModel scorePositionModel) {
        this.scorePositionModel = scorePositionModel;
    }

    /**
     * @return
     */

    public ScorePositionModel getScorePositionModel() {
        return this.scorePositionModel;
    }

    /**
     * @param scorePositionModel
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetScoresScoreidResult scorePositionModel(ScorePositionModel scorePositionModel) {
        setScorePositionModel(scorePositionModel);
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
        if (getScorePositionModel() != null)
            sb.append("ScorePositionModel: ").append(getScorePositionModel());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetScoresScoreidResult == false)
            return false;
        GetScoresScoreidResult other = (GetScoresScoreidResult) obj;
        if (other.getScorePositionModel() == null ^ this.getScorePositionModel() == null)
            return false;
        if (other.getScorePositionModel() != null && other.getScorePositionModel().equals(this.getScorePositionModel()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScorePositionModel() == null) ? 0 : getScorePositionModel().hashCode());
        return hashCode;
    }

    @Override
    public GetScoresScoreidResult clone() {
        try {
            return (GetScoresScoreidResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
