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
 * GetScoresResult JSON Unmarshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetScoresResultJsonUnmarshaller implements Unmarshaller<GetScoresResult, JsonUnmarshallerContext> {

    public GetScoresResult unmarshall(JsonUnmarshallerContext context) throws Exception {
        GetScoresResult getScoresResult = new GetScoresResult();

        int originalDepth = context.getCurrentDepth();
        String currentParentElement = context.getCurrentParentElement();
        int targetDepth = originalDepth + 1;

        JsonToken token = context.getCurrentToken();
        if (token == null)
            token = context.nextToken();
        if (token == VALUE_NULL) {
            return getScoresResult;
        }

        while (true) {
            if (token == null)
                break;

            getScoresResult.setScoreListModel(ScoreListModelJsonUnmarshaller.getInstance().unmarshall(context));
            token = context.nextToken();
        }

        return getScoresResult;
    }

    private static GetScoresResultJsonUnmarshaller instance;

    public static GetScoresResultJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new GetScoresResultJsonUnmarshaller();
        return instance;
    }
}
