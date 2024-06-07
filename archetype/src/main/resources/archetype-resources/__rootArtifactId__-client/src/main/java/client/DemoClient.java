#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client;

import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ${package}.client.javabean.req.DemoReqDto;
import ${package}.client.javabean.resp.DemoRespDto;
import com.spldeolin.satisficing.client.javabean.RequestResult;

/**
 * @author Deolin 2023-04-09
 */
@FeignClient(value = "${parentArtifactId}-service")
public interface DemoClient {

    @PostMapping("/demoMethod")
    RequestResult<DemoRespDto> demoMethod(@RequestBody @Valid DemoReqDto req);

}
