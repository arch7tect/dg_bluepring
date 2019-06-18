import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.ModelNotebook where name = :name").setParameter("name", "ScoringModel2").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.ModelPipelineWorkspace where name = :name").setParameter("name", "ScoringModel").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
Context.current.commit()
