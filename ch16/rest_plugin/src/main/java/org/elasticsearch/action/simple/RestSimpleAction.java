/*
 * Copyright [2019] [Alberto Paro]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.elasticsearch.action.simple;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.action.RestBuilderListener;

import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestRequest.Method.POST;
import static org.elasticsearch.rest.RestStatus.OK;


public class RestSimpleAction extends BaseRestHandler {
    public RestSimpleAction(Settings settings, RestController controller) {
        super(settings);
        controller.registerHandler(POST, "/_simple", this);
        controller.registerHandler(POST, "/{index}/_simple", this);
        controller.registerHandler(POST, "/_simple/{field}", this);
        controller.registerHandler(GET, "/_simple", this);
        controller.registerHandler(GET, "/{index}/_simple", this);
        controller.registerHandler(GET, "/_simple/{field}", this);
    }

    @Override
    public String getName() {
        return "simple_rest";
    }


    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
        final SimpleRequest simpleRequest = new SimpleRequest(Strings.splitStringByCommaToArray(request.param("index")));
        simpleRequest.setField(request.param("field"));
        return channel -> client.execute(SimpleAction.INSTANCE, simpleRequest, new RestBuilderListener<SimpleResponse>(channel) {
            @Override
            public RestResponse buildResponse(SimpleResponse simpleResponse, XContentBuilder builder) {
                try {
                    builder.startObject();
                    builder.field("ok", true);
                    builder.array("terms", simpleResponse.getSimple().toArray());
                    builder.endObject();

                } catch (Exception e) {
                    onFailure(e);
                }
                return new BytesRestResponse(OK, builder);
            }
        });
    }
}
