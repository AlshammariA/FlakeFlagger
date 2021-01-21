private Property getProperty(String path) throws RepositoryException {
  return getAdminSession().getProperty(path);
}
