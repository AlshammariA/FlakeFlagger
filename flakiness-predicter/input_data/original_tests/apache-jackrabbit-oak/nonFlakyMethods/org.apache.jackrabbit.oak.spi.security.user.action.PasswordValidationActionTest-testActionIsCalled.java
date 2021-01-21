@Test public void testActionIsCalled() throws Exception {
  testUser=getUserManager(root).createUser("testUser","testUser12345");
  root.commit();
  assertEquals(1,testAction.onCreateCalled);
  testUser.changePassword("pW12345678");
  assertEquals(1,testAction.onPasswordChangeCalled);
  testUser.changePassword("pW1234567890","pW12345678");
  assertEquals(2,testAction.onPasswordChangeCalled);
}
