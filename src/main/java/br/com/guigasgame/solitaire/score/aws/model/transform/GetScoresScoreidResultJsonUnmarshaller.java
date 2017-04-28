/**
 * null
 */
package br.com.guigasgame.solitaire.score.aws.model.transform;

import java.math.*;

import javax.annotation.Generated;

import br.com.guigasgame.solitaire.score.aws.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;

import com.fasterxml.jackson.core.JsonToken;
import static com.fasterxml.jackson.core.JsonToken.*;

/**
 * GetScoresScoreidResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetScoresScoreidResultJsonUnmarshaller implements Unmarshaller<GetScoresScoreidResult, JsonUnmarshallerContext> {

    public GetScoresScoreidResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetScoresScoreidResult getScoresScoreidResult = new GetScoresScoreidResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getScoresScoreidResult;
        }

        while (true) {
            if (token == null)
                break;

            getScoresScoreidResult.setScorePositionModel(ScorePositionModelJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getScoresScoreidResult;
    }

    private static GetScoresScoreidResultJsonUnmarshaller instance;

    public static GetScoresScoreidResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetScoresScoreidResultJsonUnmarshaller();
        return instance;
    }
}
