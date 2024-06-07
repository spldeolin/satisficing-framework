#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.allison1875;

import com.spldeolin.allison1875.common.Allison1875;
import com.spldeolin.allison1875.startransformer.StarTransformerConfig;
import com.spldeolin.allison1875.startransformer.StarTransformerModule;
import ${package}.service.Application;

/**
 * @author Deolin 2024-02-10
 */
public class StarTransformerBoot {

    public static void main(String[] args) {
        StarTransformerConfig config = new StarTransformerConfig();
        config.setCommonConfig(Constant.COMMON_CONFIG);
        config.setEnableLotNoAnnounce(true);

        Allison1875.allison1875(Application.class, new StarTransformerModule(config));
    }

}