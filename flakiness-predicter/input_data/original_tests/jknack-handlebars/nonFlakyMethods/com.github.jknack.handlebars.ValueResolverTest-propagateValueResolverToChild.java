@Test public void propagateValueResolverToChild() throws IOException {
  final Object userFiledAccess=new Object(){
    @SuppressWarnings("unused") private String name="User A";
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
  Template template=new Handlebars().compile("{{#each users}}{{name}}, {{/each}}");
  Context context=Context.newBuilder(users).resolver(FieldValueResolver.INSTANCE,JavaBeanValueResolver.INSTANCE).build();
  assertEquals("User A, User B, ",template.apply(context));
}
