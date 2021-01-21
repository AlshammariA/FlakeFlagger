/** 
 * @since oak
 */
@Test public void testGetEveryoneByName(){
  assertTrue(principalMgr.hasPrincipal(EveryonePrincipal.NAME));
  assertNotNull(principalMgr.getPrincipal(EveryonePrincipal.NAME));
  assertEquals(EveryonePrincipal.getInstance(),principalMgr.getPrincipal(EveryonePrincipal.NAME));
}
