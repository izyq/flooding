package club.cupk.group06.data.system.vo;

import club.cupk.group06.data.system.domain.UserRole;
import lombok.*;

import java.util.List;

/**
 * Icyの模块
 *
 * @author Icy
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

    private String token;

    private String name;

    private List<UserRole> roles;
}
