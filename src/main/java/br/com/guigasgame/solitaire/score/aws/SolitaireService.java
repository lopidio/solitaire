/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws;

import javax.annotation.Generated;

import com.amazonaws.*;
import com.amazonaws.opensdk.*;
import com.amazonaws.opensdk.model.*;
import com.amazonaws.regions.*;

import br.com.guigasgame.solitaire.score.aws.model.*;

/**
 * Interface for accessing SolitaireService.
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public interface SolitaireService {

    /**
     * @param getScoresRequest
     * @return Result of the GetScores operation returned by the service.
     * @sample SolitaireService.GetScores
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScores" target="_top">AWS
     *      API Documentation</a>
     */
    GetScoresResult getScores(GetScoresRequest getScoresRequest);

    /**
     * @param getScoresScoreidRequest
     * @return Result of the GetScoresScoreid operation returned by the service.
     * @sample SolitaireService.GetScoresScoreid
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/GetScoresScoreid"
     *      target="_top">AWS API Documentation</a>
     */
    GetScoresScoreidResult getScoresScoreid(GetScoresScoreidRequest getScoresScoreidRequest);

    /**
     * @param postScoresRequest
     * @return Result of the PostScores operation returned by the service.
     * @sample SolitaireService.PostScores
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/j13iw6luq7-2017-04-28T02:31:35Z/PostScores"
     *      target="_top">AWS API Documentation</a>
     */
    PostScoresResult postScores(PostScoresRequest postScoresRequest);

    /**
     * @return Create new instance of builder with all defaults set.
     */
    public static SolitaireServiceClientBuilder builder() {
        return new SolitaireServiceClientBuilder();
    }

    /**
     * Shuts down this client object, releasing any resources that might be held open. This is an optional method, and
     * callers are not expected to call it, but can if they want to explicitly release any open resources. Once a client
     * has been shutdown, it should not be used to make any more requests.
     */
    void shutdown();

}
