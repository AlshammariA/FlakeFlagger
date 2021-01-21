@Test public void propagateValueResolverToChildAndExtended() throws IOException {
  final Object userFiledAccess=new Object(){
    @SuppressWarnings("unused") private String name="User A";
  }
;
  final Object extended=new Object(){
    @SuppressWarnings("unused") private String role="role";
  }
;
  final Object userMethodAccess=new Object(){
    @SuppressWarnings("unused") public String getName(){
      return "User B";
    }
  }
;
  Object users=new Object(){
    @SuppressWarnings("unused") public List<Object> getUsers(){
      return Arrays.asList(userFiledAccess,userMethodAccess);
    }
  }
;
  Template template=new Handlebars().compile("{{#each users}}{{name}}-{{extended.role}}, {{/each}}");
  Context context=Context.newBuilder(users).combine("extended",extended).resolver(MapValueResolver.INSTANCE,FieldValueResolver.INSTANCE,JavaBeanValueResolver.INSTANCE).build();
  assertEquals("User A-role, User B-role, ",template.apply(context));
}
