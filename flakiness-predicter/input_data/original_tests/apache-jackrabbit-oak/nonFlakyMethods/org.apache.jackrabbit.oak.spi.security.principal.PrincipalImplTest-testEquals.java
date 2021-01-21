@Test public void testEquals(){
  List<Principal> principals=new ArrayList<Principal>();
  principals.add(new PrincipalImpl("name"));
  principals.add(new TestPrincipal("name"));
  principals.add(new JackrabbitPrincipal(){
    @Override public String getName(){
      return "name";
    }
  }
);
  for (  Principal p : principals) {
    assertEquals(principal,p);
  }
}
