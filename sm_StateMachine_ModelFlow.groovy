import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sm.StateMachine where name = :name").setParameter("name", "ModelFlow").uniqueResult() 
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
Context.current.commit()
