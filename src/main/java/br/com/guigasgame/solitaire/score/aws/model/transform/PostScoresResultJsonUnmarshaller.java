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
 * PostScoresResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class PostScoresResultJsonUnmarshaller implements Unmarshaller<PostScoresResult, JsonUnmarshallerContext> {

    public PostScoresResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        PostScoresResult postScoresResult = new PostScoresResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return postScoresResult;
        }

        while (true) {
            if (token == null)
                break;

            postScoresResult.setScoreIdModel(ScoreIdModelJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return postScoresResult;
    }

    private static PostScoresResultJsonUnmarshaller instance;

    public static PostScoresResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new PostScoresResultJsonUnmarshaller();
        return instance;
    }
}
