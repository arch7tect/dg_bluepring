import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD_BAI").uniqueResult() 
entity.parent = null
entity.cluster = session.createQuery("from sse.HadoopCluster where name = :name").setParameter("name", "test").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
Context.current.commit()
