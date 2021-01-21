private Node getNode(String path) throws RepositoryException {
  return getAdminSession().getNode(path);
}
