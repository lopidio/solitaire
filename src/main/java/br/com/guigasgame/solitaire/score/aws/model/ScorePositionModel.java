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
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/ScorePositionModel"
 *      target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class ScorePositionModel implements Serializable, Cloneable, StructuredPojo {

    private Integer index;

    private String itemId;

    private Integer total;

    /**
     * @param index
     */

    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * @return
     */

    public Integer getIndex() {
        return this.index;
    }

    /**
     * @param index
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScorePositionModel index(Integer index) {
        setIndex(index);
        return this;
    }

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

    public ScorePositionModel itemId(String itemId) {
        setItemId(itemId);
        return this;
    }

    /**
     * @param total
     */

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return
     */

    public Integer getTotal() {
        return this.total;
    }

    /**
     * @param total
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public ScorePositionModel total(Integer total) {
        setTotal(total);
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
        if (getIndex() != null)
            sb.append("Index: ").append(getIndex()).append(",");
        if (getItemId() != null)
            sb.append("ItemId: ").append(getItemId()).append(",");
        if (getTotal() != null)
            sb.append("Total: ").append(getTotal());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ScorePositionModel == false)
            return false;
        ScorePositionModel other = (ScorePositionModel) obj;
        if (other.getIndex() == null ^ this.getIndex() == null)
            return false;
        if (other.getIndex() != null && other.getIndex().equals(this.getIndex()) == false)
            return false;
        if (other.getItemId() == null ^ this.getItemId() == null)
            return false;
        if (other.getItemId() != null && other.getItemId().equals(this.getItemId()) == false)
            return false;
        if (other.getTotal() == null ^ this.getTotal() == null)
            return false;
        if (other.getTotal() != null && other.getTotal().equals(this.getTotal()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getIndex() == null) ? 0 : getIndex().hashCode());
        hashCode = prime * hashCode + ((getItemId() == null) ? 0 : getItemId().hashCode());
        hashCode = prime * hashCode + ((getTotal() == null) ? 0 : getTotal().hashCode());
        return hashCode;
    }

    @Override
    public ScorePositionModel clone() {
        try {
            return (ScorePositionModel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        br.com.guigasgame.solitaire.score.aws.model.transform.ScorePositionModelMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
