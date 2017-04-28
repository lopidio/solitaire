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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/ScoreIdModel" target="_top">AWS
 *      API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScoreIdModel implements Serializable, Cloneable, StructuredPojo {

    private String itemId;

    /**
     * @param itemId
     */

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return
     */

    public String getItemId() {
        return this.itemId;
    }

    /**
     * @param itemId
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScoreIdModel itemId(String itemId) {
        setItemId(itemId);
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
        if (getItemId() != null)
            sb.append("ItemId: ").append(getItemId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ScoreIdModel == false)
            return false;
        ScoreIdModel other = (ScoreIdModel) obj;
        if (other.getItemId() == null ^ this.getItemId() == null)
            return false;
        if (other.getItemId() != null && other.getItemId().equals(this.getItemId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getItemId() == null) ? 0 : getItemId().hashCode());
        return hashCode;
    }

    @Override
    public ScoreIdModel clone() {
        try {
            return (ScoreIdModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        br.com.guigasgame.solitaire.score.aws.model.transform.ScoreIdModelMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
