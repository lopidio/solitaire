/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model;

import java.io.Serializable;
import javax.annotation.Generated;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScores" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetScoresResult extends com.amazonaws.opensdk.BaseResult implements Serializable, Cloneable {

    private ScoreListModel scoreListModel;

    /**
     * @param scoreListModel
     */

    public void setScoreListModel(ScoreListModel scoreListModel) {
        this.scoreListModel = scoreListModel;
    }

    /**
     * @return
     */

    public ScoreListModel getScoreListModel() {
        return this.scoreListModel;
    }

    /**
     * @param scoreListModel
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetScoresResult scoreListModel(ScoreListModel scoreListModel) {
        setScoreListModel(scoreListModel);
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
        if (getScoreListModel() != null)
            sb.append("ScoreListModel: ").append(getScoreListModel());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetScoresResult == false)
            return false;
        GetScoresResult other = (GetScoresResult) obj;
        if (other.getScoreListModel() == null ^ this.getScoreListModel() == null)
            return false;
        if (other.getScoreListModel() != null && other.getScoreListModel().equals(this.getScoreListModel()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScoreListModel() == null) ? 0 : getScoreListModel().hashCode());
        return hashCode;
    }

    @Override
    public GetScoresResult clone() {
        try {
            return (GetScoresResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}
