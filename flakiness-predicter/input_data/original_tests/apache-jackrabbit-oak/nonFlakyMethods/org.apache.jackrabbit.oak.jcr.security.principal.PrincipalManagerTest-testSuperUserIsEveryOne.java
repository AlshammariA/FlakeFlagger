@Test public void testSuperUserIsEveryOne(){
  for (  Principal pcpl : adminPrincipals) {
    if (!(pcpl.equals(everyone))) {
      assertTrue(everyone.isMember(pcpl));
    }
  }
}
