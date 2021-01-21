@Test public void testPrefixMatch(){
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("/x/*");
    assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a");
    ElementSelector ruleElementSelector=new ElementSelector("/x/*");
    assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("/a/*");
    assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("/A/*");
    assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/A/b");
    ElementSelector ruleElementSelector=new ElementSelector("/a/*");
    assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("/a/b/*");
    assertEquals(2,ruleElementSelector.getPrefixMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("/*");
    assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
  }
}
