@Test public void testAccessPrincipalOfDisabledUser() throws Exception {
  user.disable("readonly user is disabled!");
  superuser.save();
  Principal principal=user.getPrincipal();
  assertTrue(((JackrabbitSession)superuser).getPrincipalManager().hasPrincipal(principal.getName()));
  assertEquals(principal,((JackrabbitSession)superuser).getPrincipalManager().getPrincipal(principal.getName()));
}
