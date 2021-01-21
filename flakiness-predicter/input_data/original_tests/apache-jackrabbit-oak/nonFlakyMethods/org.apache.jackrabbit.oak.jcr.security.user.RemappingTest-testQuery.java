@Test public void testQuery() throws Exception {
  Iterator<Authorizable> result=getUserManager(session).findAuthorizables(new Query(){
    public <T>void build(    QueryBuilder<T> builder){
      builder.setCondition(builder.eq("@my:property",vf.createValue("value")));
    }
  }
);
  assertTrue(result.hasNext());
  assertEquals(user.getID(),result.next().getID());
}
