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
public class GetScoresScoreidRequest extends com.amazonaws.opensdk.BaseRequest implements Serializable, Cloneable {

    private String scoreid;

    /**
     * @param scoreid
     */

    public void setScoreid(String scoreid) {
        this.scoreid = scoreid;
    }

    /**
     * @return
     */

    public String getScoreid() {
        return this.scoreid;
    }

    /**
     * @param scoreid
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public GetScoresScoreidRequest scoreid(String scoreid) {
        setScoreid(scoreid);
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
        if (getScoreid() != null)
            sb.append("Scoreid: ").append(getScoreid());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof GetScoresScoreidRequest == false)
            return false;
        GetScoresScoreidRequest other = (GetScoresScoreidRequest) obj;
        if (other.getScoreid() == null ^ this.getScoreid() == null)
            return false;
        if (other.getScoreid() != null && other.getScoreid().equals(this.getScoreid()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getScoreid() == null) ? 0 : getScoreid().hashCode());
        return hashCode;
    }

    @Override
    public GetScoresScoreidRequest clone() {
        return (GetScoresScoreidRequest) super.clone();
    }

    /**
     * Set the configuration for this request.
     *
     * @param sdkRequestConfig
     *        Request configuration.
     * @return This object for method chaining.
     */
    public GetScoresScoreidRequest sdkRequestConfig(com.amazonaws.opensdk.SdkRequestConfig sdkRequestConfig) {
        super.sdkRequestConfig(sdkRequestConfig);
        return this;
    }

}
