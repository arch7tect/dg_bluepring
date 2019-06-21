import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "BAI_PDModel").uniqueResult() 
entity.userDefinedFunctions.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.targets.find {it.name == "Local_4"}.context = null
entity.targets.find {it.name == "Local_7"}.context = null
entity.targets.find {it.name == "Local_10"}.context = null
entity.targets.find {it.name == "Local_13"}.context = null
entity.targets.find {it.name == "Local_16"}.context = null
entity.targets.find {it.name == "Local_1"}.context = null
entity.sources.find {it.name == "DictPortfolio"}.context = null
entity.sources.find {it.name == "GE_EconomicActivityMissing"}.context = null
entity.sources.find {it.name == "rcdataAccounts"}.context = null
entity.sources.find {it.name == "rcdataForbearance"}.context = null
entity.sources.find {it.name == "Sectores_de_Economia"}.context = null
entity.sources.find {it.name == "WriteOff"}.context = null
Context.current.commit()
