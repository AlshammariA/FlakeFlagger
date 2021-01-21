@Test public void loginWithAttribute() throws RepositoryException {
  Session session=((JackrabbitRepository)getRepository()).login(new GuestCredentials(),null,Collections.<String,Object>singletonMap(RepositoryImpl.REFRESH_INTERVAL,42));
  String[] attributeNames=session.getAttributeNames();
  assertEquals(1,attributeNames.length);
  assertEquals(RepositoryImpl.REFRESH_INTERVAL,attributeNames[0]);
  assertEquals(42L,session.getAttribute(RepositoryImpl.REFRESH_INTERVAL));
}
