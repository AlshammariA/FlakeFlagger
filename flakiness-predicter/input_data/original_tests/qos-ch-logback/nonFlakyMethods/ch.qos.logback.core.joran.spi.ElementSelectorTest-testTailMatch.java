@Test public void testTailMatch(){
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("*");
    assertEquals(0,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a");
    ElementSelector ruleElementSelector=new ElementSelector("*/a");
    assertEquals(1,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/A");
    ElementSelector ruleElementSelector=new ElementSelector("*/a");
    assertEquals(1,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a");
    ElementSelector ruleElementSelector=new ElementSelector("*/A");
    assertEquals(1,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b");
    ElementSelector ruleElementSelector=new ElementSelector("*/b");
    assertEquals(1,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/B");
    ElementSelector ruleElementSelector=new ElementSelector("*/b");
    assertEquals(1,ruleElementSelector.getTailMatchLength(p));
  }
{
    ElementPath p=new ElementPath("/a/b/c");
    ElementSelector ruleElementSelector=new ElementSelector("*/b/c");
    assertEquals(2,ruleElementSelector.getTailMatchLength(p));
  }
}
