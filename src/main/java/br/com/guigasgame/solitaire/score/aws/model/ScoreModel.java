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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/ScoreModel" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreModel implements Serializable, Cloneable, StructuredPojo {

    private Integer dateValue;

    private String playerName;

    private Integer score;

    private Double totalTime;

    private Integer transactionCounter;

    /**
     * @param dateValue
     */

    public void setDate(Integer dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * @return
     */

    public Integer getDate() {
        return this.dateValue;
    }

    /**
     * @param dateValue
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreModel date(Integer dateValue) {
        setDate(dateValue);
        return this;
    }

    /**
     * @param playerName
     */

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return
     */

    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * @param playerName
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreModel playerName(String playerName) {
        setPlayerName(playerName);
        return this;
    }

    /**
     * @param score
     */

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return
     */

    public Integer getScore() {
        return this.score;
    }

    /**
     * @param score
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreModel score(Integer score) {
        setScore(score);
        return this;
    }

    /**
     * @param totalTime
     */

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * @return
     */

    public Double getTotalTime() {
        return this.totalTime;
    }

    /**
     * @param totalTime
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreModel totalTime(Double totalTime) {
        setTotalTime(totalTime);
        return this;
    }

    /**
     * @param transactionCounter
     */

    public void setTransactionCounter(Integer transactionCounter) {
        this.transactionCounter = transactionCounter;
    }

    /**
     * @return
     */

    public Integer getTransactionCounter() {
        return this.transactionCounter;
    }

    /**
     * @param transactionCounter
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreModel transactionCounter(Integer transactionCounter) {
        setTransactionCounter(transactionCounter);
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
        if (getDate() != null)
            sb.append("Date: ").append(getDate()).append(",");
        if (getPlayerName() != null)
            sb.append("PlayerName: ").append(getPlayerName()).append(",");
        if (getScore() != null)
            sb.append("Score: ").append(getScore()).append(",");
        if (getTotalTime() != null)
            sb.append("TotalTime: ").append(getTotalTime()).append(",");
        if (getTransactionCounter() != null)
            sb.append("TransactionCounter: ").append(getTransactionCounter());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ScoreModel == false)
            return false;
        ScoreModel other = (ScoreModel) obj;
        if (other.getDate() == null ^ this.getDate() == null)
            return false;
        if (other.getDate() != null && other.getDate().equals(this.getDate()) == false)
            return false;
        if (other.getPlayerName() == null ^ this.getPlayerName() == null)
            return false;
        if (other.getPlayerName() != null && other.getPlayerName().equals(this.getPlayerName()) == false)
            return false;
        if (other.getScore() == null ^ this.getScore() == null)
            return false;
        if (other.getScore() != null && other.getScore().equals(this.getScore()) == false)
            return false;
        if (other.getTotalTime() == null ^ this.getTotalTime() == null)
            return false;
        if (other.getTotalTime() != null && other.getTotalTime().equals(this.getTotalTime()) == false)
            return false;
        if (other.getTransactionCounter() == null ^ this.getTransactionCounter() == null)
            return false;
        if (other.getTransactionCounter() != null && other.getTransactionCounter().equals(this.getTransactionCounter()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getDate() == null) ? 0 : getDate().hashCode());
        hashCode = prime * hashCode + ((getPlayerName() == null) ? 0 : getPlayerName().hashCode());
        hashCode = prime * hashCode + ((getScore() == null) ? 0 : getScore().hashCode());
        hashCode = prime * hashCode + ((getTotalTime() == null) ? 0 : getTotalTime().hashCode());
        hashCode = prime * hashCode + ((getTransactionCounter() == null) ? 0 : getTransactionCounter().hashCode());
        return hashCode;
    }

    @Override
    public ScoreModel clone() {
        try {
            return (ScoreModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        br.com.guigasgame.solitaire.score.aws.model.transform.ScoreModelMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
