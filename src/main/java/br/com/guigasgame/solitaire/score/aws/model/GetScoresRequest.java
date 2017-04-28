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
public class GetScoresRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private String num;

    /**
     * @param num
     */

    public void setNum(String num) {
        this.num = num;
    }

    /**
     * @return
     */

    public String getNum() {
        return this.num;
    }

    /**
     * @param num
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetScoresRequest num(String num) {
        setNum(num);
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
        if (getNum() != null)
            sb.append("Num: ").append(getNum());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetScoresRequest == false)
            return false;
        GetScoresRequest other = (GetScoresRequest) obj;
        if (other.getNum() == null ^ this.getNum() == null)
            return false;
        if (other.getNum() != null && other.getNum().equals(this.getNum()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getNum() == null) ? 0 : getNum().hashCode());
        return hashCode;
    }

    @Override
    public GetScoresRequest clone() {
        return (GetScoresRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public GetScoresRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
