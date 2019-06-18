import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD").uniqueResult() 
entity.parent = null
entity.cluster = session.createQuery("from sse.HadoopCluster where name = :name").setParameter("name", "default_cluster").uniqueResult()
entity.project = null
Context.current.commit()
