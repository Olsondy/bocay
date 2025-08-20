package priv.bocayouth.common.core.feat.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Olsond
 * @date 2025/8/20 07:07
 * @description api 页面访问
 */

@Data
@Slf4j
@Controller
@RequestMapping("/v3/api-docs")
public class APIdocController {

    @Value("${springdoc.api-docs.v3-url:/v3/api-docs/yaml}")
    private String apiDocsUrl;


    @Value("${springdoc.api-docs.hideDownloadButton:false}")
    private boolean hideDownloadButton;
    /**
     * API接口
     */
    @Hidden
    @GetMapping(value = "/index")
    public String scalarApiReference (Model model) {
        model.addAttribute("apiDocsUrl", apiDocsUrl);
        model.addAttribute("hideDownloadButton", hideDownloadButton);
        return "api/docs";
    }
}
