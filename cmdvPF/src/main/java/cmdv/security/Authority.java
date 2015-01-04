package cmdv.security;

import org.springframework.security.core.GrantedAuthority;


public class Authority implements GrantedAuthority{
  private static final long serialVersionUID = 9170140593525051237L;

  private String authority;

  public Authority(String authority) {
    super();
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return authority;
  }
  @Override
  public String toString() {
    return "Authority [authority=" + authority + "]";
  }

}