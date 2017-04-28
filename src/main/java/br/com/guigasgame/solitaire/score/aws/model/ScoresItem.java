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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/ScoresItem" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoresItem implements Serializable, Cloneable, StructuredPojo {

    private String awsDate;

    private String dateValue;

    private String id;

    private String playerName;

    private Integer score;

    private Double totalTime;

    private Integer transactionCounter;

    /**
     * @param awsDate
     */

    public void setAwsDate(String awsDate) {
        this.awsDate = awsDate;
    }

    /**
     * @return
     */

    public String getAwsDate() {
        return this.awsDate;
    }

    /**
     * @param awsDate
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoresItem awsDate(String awsDate) {
        setAwsDate(awsDate);
        return this;
    }

    /**
     * @param dateValue
     */

    public void setDate(String dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * @return
     */

    public String getDate() {
        return this.dateValue;
    }

    /**
     * @param dateValue
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoresItem date(String dateValue) {
        setDate(dateValue);
        return this;
    }

    /**
     * @param id
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return
     */

    public String getId() {
        return this.id;
    }

    /**
     * @param id
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoresItem id(String id) {
        setId(id);
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

    public ScoresItem playerName(String playerName) {
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

    public ScoresItem score(Integer score) {
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

    public ScoresItem totalTime(Double totalTime) {
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

    public ScoresItem transactionCounter(Integer transactionCounter) {
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
        if (getAwsDate() != null)
            sb.append("AwsDate: ").append(getAwsDate()).append(",");
        if (getDate() != null)
            sb.append("Date: ").append(getDate()).append(",");
        if (getId() != null)
            sb.append("Id: ").append(getId()).append(",");
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

        if (obj instanceof ScoresItem == false)
            return false;
        ScoresItem other = (ScoresItem) obj;
        if (other.getAwsDate() == null ^ this.getAwsDate() == null)
            return false;
        if (other.getAwsDate() != null && other.getAwsDate().equals(this.getAwsDate()) == false)
            return false;
        if (other.getDate() == null ^ this.getDate() == null)
            return false;
        if (other.getDate() != null && other.getDate().equals(this.getDate()) == false)
            return false;
        if (other.getId() == null ^ this.getId() == null)
            return false;
        if (other.getId() != null && other.getId().equals(this.getId()) == false)
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

        hashCode = prime * hashCode + ((getAwsDate() == null) ? 0 : getAwsDate().hashCode());
        hashCode = prime * hashCode + ((getDate() == null) ? 0 : getDate().hashCode());
        hashCode = prime * hashCode + ((getId() == null) ? 0 : getId().hashCode());
        hashCode = prime * hashCode + ((getPlayerName() == null) ? 0 : getPlayerName().hashCode());
        hashCode = prime * hashCode + ((getScore() == null) ? 0 : getScore().hashCode());
        hashCode = prime * hashCode + ((getTotalTime() == null) ? 0 : getTotalTime().hashCode());
        hashCode = prime * hashCode + ((getTransactionCounter() == null) ? 0 : getTransactionCounter().hashCode());
        return hashCode;
    }

    @Override
    public ScoresItem clone() {
        try {
            return (ScoresItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        br.com.guigasgame.solitaire.score.aws.model.transform.ScoresItemMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
