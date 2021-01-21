@Test public void testNotEquals(){
  List<Principal> principals=new ArrayList<Principal>();
  principals.add(new PrincipalImpl("otherName"));
  principals.add(new Principal(){
    @Override public String getName(){
      return "name";
    }
  }
);
  for (  Principal p : principals) {
    assertFalse(principal.equals(p));
  }
}
