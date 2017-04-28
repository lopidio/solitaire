/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/ScoreListModel"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreListModel implements Serializable, Cloneable, StructuredPojo {

    private java.util.List<ScoresItem> scores;

    /**
     * @return
     */

    public java.util.List<ScoresItem> getScores() {
        return scores;
    }

    /**
     * @param scores
     */

    public void setScores(java.util.Collection<ScoresItem> scores) {
        if (scores == null) {
            this.scores = null;
            return;
        }

        this.scores = new java.util.ArrayList<ScoresItem>(scores);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setScores(java.util.Collection)} or {@link #withScores(java.util.Collection)} if you want to override the
     * existing values.
     * </p>
     * 
     * @param scores
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreListModel scores(ScoresItem... scores) {
        if (this.scores == null) {
            setScores(new java.util.ArrayList<ScoresItem>(scores.length));
        }
        for (ScoresItem ele : scores) {
            this.scores.add(ele);
        }
        return this;
    }

    /**
     * @param scores
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreListModel scores(java.util.Collection<ScoresItem> scores) {
        setScores(scores);
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
        if (getScores() != null)
            sb.append("Scores: ").append(getScores());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ScoreListModel == false)
            return false;
        ScoreListModel other = (ScoreListModel) obj;
        if (other.getScores() == null ^ this.getScores() == null)
            return false;
        if (other.getScores() != null && other.getScores().equals(this.getScores()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScores() == null) ? 0 : getScores().hashCode());
        return hashCode;
    }

    @Override
    public ScoreListModel clone() {
        try {
            return (ScoreListModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        br.com.guigasgame.solitaire.score.aws.model.transform.ScoreListModelMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
