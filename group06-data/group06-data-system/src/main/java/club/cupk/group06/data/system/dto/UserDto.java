package club.cupk.group06.data.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangdaff
 * @date 2023-06-19 15:47
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userPhone;
    private String userName;
    private String userEmail;
    private String userWell;
    private String userField;
}
