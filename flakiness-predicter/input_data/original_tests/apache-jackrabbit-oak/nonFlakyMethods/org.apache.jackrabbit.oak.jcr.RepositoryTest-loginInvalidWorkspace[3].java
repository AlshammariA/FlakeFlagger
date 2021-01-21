@Test(expected=NoSuchWorkspaceException.class) public void loginInvalidWorkspace() throws RepositoryException {
  Repository repository=getRepository();
  repository.login(new GuestCredentials(),"invalid");
}
