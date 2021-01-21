@Test public void testIllegalChars() throws Exception {
  UserProvider userProvider=createUserProvider();
  Map<String,String> m=new HashMap<String,String>();
  m.put("z[x]","/z/" + Text.escapeIllegalJcrChars("z[") + '/'+ Text.escapeIllegalJcrChars("z[x]"));
  m.put("z*x","/z/" + Text.escapeIllegalJcrChars("z*") + '/'+ Text.escapeIllegalJcrChars("z*x"));
  m.put("z/x","/z/" + Text.escapeIllegalJcrChars("z/") + '/'+ Text.escapeIllegalJcrChars("z/x"));
  m.put("%\r|",'/' + Text.escapeIllegalJcrChars("%") + '/'+ Text.escapeIllegalJcrChars("%\r")+ '/'+ Text.escapeIllegalJcrChars("%\r|"));
  for (  String uid : m.keySet()) {
    Tree user=userProvider.createUser(uid,null);
    root.commit();
    assertEquals(defaultUserPath + m.get(uid),user.getPath());
    assertEquals(uid,UserUtil.getAuthorizableId(user));
    Tree ath=userProvider.getAuthorizable(uid);
    assertNotNull("Tree with id " + uid + " must exist.",ath);
  }
}
