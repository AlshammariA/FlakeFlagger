/** 
 * Add a node to a node type that does not accept child nodes See OAK-479
 */
@Test(expected=ConstraintViolationException.class) public void illegalAddNode() throws Exception {
  Session session=getAdminSession();
  Node root=session.getRootNode();
  root.addNode("q1","nt:query").addNode("q2","nt:query");
  session.save();
}
