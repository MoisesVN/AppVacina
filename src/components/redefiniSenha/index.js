import { View,Text,TouchableOpacity,Image, TextInput } from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "./style";

export default function Info(){
    const navigation = useNavigation();
    return(
    <View style={styles.Tela1}>
        <View style={styles.Tela}> 

    <View style={styles.Tela}><Text style={styles.Text}> Redefinir Senha</Text>
    <TextInput
                        style={styles.textinput}
                        placeholder="Código de verificação"
                        
                        />
                        <TextInput
                        style={styles.textinput}
                        placeholder="Nova senha"
                        secureTextEntry={true}
                        />
                        <TextInput
                        style={styles.textinput}
                        placeholder="Confirmar senha" 
                        secureTextEntry={true}
                        />
    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao2}>
    <Text style={styles.Text2}>Confirmar</Text>
    </TouchableOpacity>
    </View>
    </View>
    </View>
    )
}

