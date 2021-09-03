package com.jwt.jwtdemo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LowTaste
 * @since 2021-09-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
@ToString
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String name;

    private String password;


}
