job = {
    'title': 'Senior Linux Cloud Engineer',
    'department': 'Information Technology and Network Services',
    'at': 'West Hollywood, CA'
}

company = {
    'name': 'CityGrid Media',
    'links': ['local advertising organizations', 'web and mobile publishers'],
    'part_of': 'IAC',
    'owns_and_operates': ['Citysearch', 'UrbanSpoon', 'Insider Pages'],
    'trajectory': 'upward',
    'working_culture': 'people focused',
    'equal_opportunity_employer': True,
    'contact': 'http://www/citygridmedia.com'
}

team = {
    'attributes': ['diverse', 'highly skilled'],
    'responsibilities': {
        'environment': {
            'increasingly virtualized': True,
            'virtualization technologies': ['Xen', 'Eucalyptus'],
            'approximate_physical_server_count': 200,
            'amazon_cloud_presence': 'expanding',
        }
    }
}

def has_background(candidate):
    cloud_skills = re.compile('EC2|S3|Eucalyptus|Kaavo|GoGrid|CohesiveFT|Enomaly|enStratus')
    return (candidate.years_of_unix_administration_experience >= 5 and
        len(set(["Shell", "Python", "Ruby", "Perl"]) - candidate.skills) >= 2 and
        "Configuration Management" in candidate.experience and
        re.match(cloud_skills, candidate.cloud_skills) and
        "High" in candidate.web_traffic_experience and
        "Load balancing" in candidate.skills and
        "Virtualization" in candidate.skills)           # Xen, VMWare

def has_bonus_skills(candidate):
    return "Hadoop" in candidate.skills

def daily_activity():
    work_in(Environment(pace='fast', mode='agile', technology='high'))
    work_with(Tech_Stack(flavor='open source', platform='cloud'), developers)
    contribute('hands on', collaborators='team')
    automate('entire cluster provisioning')
    write_scripts(['python', 'shell'])
    
