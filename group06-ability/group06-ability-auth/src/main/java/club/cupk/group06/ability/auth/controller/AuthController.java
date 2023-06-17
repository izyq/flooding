package club.cupk.group06.ability.auth.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */

@Api(tags = "认证模块")
@Validated
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

}
