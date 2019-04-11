import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from rt.LivyServer where name = :name").setParameter("name", "LivyOnCloud2").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "simpleTest").uniqueResult()
Context.current.commit()
