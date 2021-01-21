@Test public void testBuildPasswordHash() throws Exception {
  for (  String pw : plainPasswords) {
    String pwHash=PasswordUtil.buildPasswordHash(pw);
    assertFalse(pw.equals(pwHash));
  }
  List<Integer[]> l=new ArrayList<Integer[]>();
  l.add(new Integer[]{0,1000});
  l.add(new Integer[]{1,10});
  l.add(new Integer[]{8,50});
  l.add(new Integer[]{10,5});
  l.add(new Integer[]{-1,-1});
  for (  Integer[] params : l) {
    for (    String pw : plainPasswords) {
      int saltsize=params[0];
      int iterations=params[1];
      String pwHash=PasswordUtil.buildPasswordHash(pw,PasswordUtil.DEFAULT_ALGORITHM,saltsize,iterations);
      assertFalse(pw.equals(pwHash));
    }
  }
}
